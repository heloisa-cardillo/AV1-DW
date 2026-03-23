package com.autobots.automanager.utilitarios;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataFormatador {

    private static final String FORMATOR = "dd/MM/yyyy";

    public String formatar(Date data) {
        if (data == null) return "";
        return new SimpleDateFormat(FORMATOR).format(data);
    }

    public String formatar(Date data, String formato) {
        if (data == null) return "";
        return new SimpleDateFormat(formato).format(data);
    }
}