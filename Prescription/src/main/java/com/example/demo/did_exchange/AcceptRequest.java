package com.example.demo.did_exchange;
import javax.annotation.Nonnull;
import java.util.List;

public class AcceptRequest {



        @Nonnull
        private String conn_id;
        private String meditation_id;
        private String my_endpoind;

        public AcceptRequest(@Nonnull String conn_id, String meditation_id, String my_endpoind) {
                this.conn_id = conn_id;
                this.meditation_id = meditation_id;
                this.my_endpoind = my_endpoind;
        }
}

