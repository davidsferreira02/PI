if (process.env.NODE_ENV !== "production") {
    require("dotenv").config()
}


// Importing Libraies that we installed using npm
const express = require("express")
const app = express()
const bcrypt = require("bcrypt") // Importing bcrypt package
const passport = require("passport")
const initializePassport = require("./passport-config")
const flash = require("express-flash")
const session = require("express-session")
const methodOverride = require("method-override")
const {Pool} = require('pg');
const pool = new Pool({
    user: 'postgres',
    password: 'postgres',
    host: 'localhost',
    database: 'postgres',
    port: '5432'
});


initializePassport(
    passport,
    username => users.find(user => user.username === username),
    id => users.find(user => user.id === id)
)


const users = []
const prescriptions = []

app.use(express.urlencoded({extended: false}))
app.use(flash())
app.use(session({
    secret: process.env.SESSION_SECRET,
    resave: false, // We wont resave the session variable if nothing is changed
    saveUninitialized: false
}))
app.use(passport.initialize())
app.use(passport.session())
app.use(methodOverride("_method"))

app.post("/login", checkNotAuthenticated, (req, res, next) => {
    passport.authenticate("local", async (err, user, info) => {
        if (err) {
            return next(err);
        }
        if (!user) {
            req.flash("error", "Invalid username or password");
            return res.redirect("/login");
        }
        req.logIn(user, async (err) => {
            if (err) {
                return next(err);
            }

            try {
                const query = 'SELECT type FROM users WHERE username = $1';
                const result = await pool.query(query, [req.body.username]);

                if (result.rows.length > 0) {
                    const userType = result.rows[0].type;

                    if (userType === "pacient") {
                        return res.redirect("/pacient");
                    } else if (userType === "doctor") {
                        return res.redirect("/doctor");
                    }
                }

                return res.redirect("/");
            } catch (e) {
                return next(e);
            }
        });
    })(req, res, next);
});


app.post("/register", checkNotAuthenticated, async (req, res) => {
    try {
        const hashedPassword = await bcrypt.hash(req.body.password, 10);

        const query = 'INSERT INTO users (id, age,gender,name,password,role,username) VALUES ($1, $2, $3, $4, $5, $6, $7)';
        const values = [
            Date.now().toString(),
            req.body.age,
            req.body.gender,
            req.body.name,
            req.body.email,
            req.body.age,
            hashedPassword,
            req.body.role,
            req.body.username
        ];

        await pool.query(query, values);
        console.log('New user registered:', req.body.username);

        res.redirect("/login");
    } catch (e) {
        console.log(e);
        res.redirect("/register");
    }
});


app.get("/pacient", checkAuthenticated, (req, res) => {
    // Verifica se o usuário logado é do tipo "pacient"
    if (req.user.type === "pacient") {
        // Filtra as prescrições para exibir apenas as do paciente logado
        const patientPrescriptions = prescriptions.filter(
            (prescription) => prescription.patientId === req.user.id
        );
        res.render("pacient.ejs", {prescriptions: patientPrescriptions});
    } else {
        // Redireciona para a página inicial se o usuário não for do tipo "pacient"
        res.redirect("/");
    }
});
app.post("/doctor", checkAuthenticated, (req, res) => {
    // Verifica se o usuário logado é do tipo "doctor"
    if (req.user.type === "doctor") {
        // Obtém os dados da prescrição do corpo da requisição
        const {patientId, medication, dosage, duration} = req.body;

        // Crie uma nova prescrição com os dados fornecidos
        const newPrescription = {
            patientId,
            medication,
            dosage,
            duration,
        };

        // Adicione a nova prescrição à lista de prescrições
        prescriptions.push(newPrescription);

        // Redireciona de volta para a página do médico
        res.redirect("/doctor");
    } else {
        // Redireciona para a página inicial se o usuário não for do tipo "doctor"
        res.redirect("/");
    }
});


// Routes
app.get('/', checkAuthenticated, (req, res) => {
    res.render("index.ejs", {username: req.user.username})
})

app.get('/login', checkNotAuthenticated, (req, res) => {
    res.render("login.ejs")
})

app.get('/register', checkNotAuthenticated, (req, res) => {
    res.render("register.ejs")
})

app.get('/pacient', checkAuthenticated, (req, res) => {
    res.render("pacient.ejs")
})
app.get('/doctor', checkAuthenticated, (req, res) => {
    res.render("doctor.ejs")
})

// End Routes


app.delete("/logout", (req, res) => {
    req.logout(req.user, err => {
        if (err) return next(err)
        res.redirect("/")
    })
})

function checkAuthenticated(req, res, next) {
    if (req.isAuthenticated()) {
        return next()
    }
    res.redirect("/login")
}

function checkNotAuthenticated(req, res, next) {
    if (req.isAuthenticated()) {
        return res.redirect("/")
    }
    next()
}

app.listen(3000)