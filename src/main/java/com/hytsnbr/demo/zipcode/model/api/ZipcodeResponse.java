package com.hytsnbr.demo.zipcode.model.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
public class ZipcodeResponse {

    @JsonProperty("status")
    int status;

    @JsonProperty("massage")
    String massage;

    @JsonProperty("results")
    List<Result> results;

    @Getter
    @Setter
    @NoArgsConstructor
    public class Result {

        @JsonProperty("zipcode")
        String zipcode;

        @JsonProperty("prefcode")
        String prefcode;

        @JsonProperty("address1")
        String address1;

        @JsonProperty("address2")
        String address2;

        @JsonProperty("address3")
        String address3;

        @JsonProperty("kana1")
        String kana1;

        @JsonProperty("kana2")
        String kana2;

        @JsonProperty("kana3")
        String kana3;

        public String getAddress() {
            return address1 + address2 + address3 + kana1 + kana2 + kana3;
        }
    }
}
