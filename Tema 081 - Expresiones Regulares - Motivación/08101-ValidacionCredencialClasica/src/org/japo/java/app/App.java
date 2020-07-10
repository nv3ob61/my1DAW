/*
 * Copyright 2019 mon_mo.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.app;

import org.japo.java.libraries.UtilesEntrada;
import org.japo.java.libraries.UtilesPassword;
import static org.japo.java.libraries.UtilesPassword.validarContenido;
import static org.japo.java.libraries.UtilesPassword.validarLongitud;
import static org.japo.java.libraries.UtilesPassword.validarStrDig;
import static org.japo.java.libraries.UtilesPassword.validarStrMay;
import static org.japo.java.libraries.UtilesPassword.validarStrMin;
import static org.japo.java.libraries.UtilesPassword.validarStrPun;

/**
 *
 * @author mon_mo
 */
public final class App {

    public static final String DEF_USER = "Usuario ......: ";
    public static final String DEF_PASS = "Contraseña ...: ";

    public final void launchApp() {
        String user;
        String pass;

        System.out.println("CREACIÓN DE PERFIL DE USUARIO");
        System.out.println("=============================");

        user = UtilesEntrada.leerTexto(DEF_USER);

        //La castaña de la araña
        if (!validarLongitud(user.length(), UtilesPassword.LEN_MIN_USER, UtilesPassword.LEN_MAX_USER)) {
            System.out.printf("Usuario ...: %s%n", UtilesPassword.MSG_ERR_LEN_USER);
        } else if (!validarStrMin(user)) {
            System.out.printf("Usuario ...: %s%n", UtilesPassword.MSG_ERR_LWR_USER);
        } else if (!validarStrMay(user)) {
            System.out.printf("Usuario ...: %s%n", UtilesPassword.MSG_ERR_UPR_USER);
        } else if (!validarStrDig(user)) {
            System.out.printf("Usuario ...: %s%n", UtilesPassword.MSG_ERR_DIG_USER);
        } else if (!validarStrPun(user)) {
            System.out.printf("Usuario ...: %s%n", UtilesPassword.MSG_ERR_EXT_USER);
        } else if (!validarContenido(user,
                UtilesPassword.SET_LWR_PASS, UtilesPassword.SET_UPR_PASS,
                UtilesPassword.SET_DIG_PASS, UtilesPassword.SET_EXT_PASS)) {
            System.out.printf("Contraseña ...: %s%n", UtilesPassword.MSG_ERR_PASS);
        } else {
            System.out.printf("Usuario ...: %s%n", UtilesPassword.MSG_SUC_USER);
        }

        //Separador
        System.out.println("---");

        //Lo mismo para el pass:
        pass = UtilesEntrada.leerTexto(DEF_PASS);

        if (!validarLongitud(pass.length(), UtilesPassword.LEN_MIN_PASS, UtilesPassword.LEN_MAX_PASS)) {
            System.out.printf("Usuario ...: %s%n", UtilesPassword.MSG_ERR_LEN_PASS);
        } else if (!validarStrMin(pass)) {
            System.out.printf("Usuario ...: %s%n", UtilesPassword.MSG_ERR_LWR_PASS);
        } else if (!validarStrMay(pass)) {
            System.out.printf("Usuario ...: %s%n", UtilesPassword.MSG_ERR_UPR_PASS);
        } else if (!validarStrDig(pass)) {
            System.out.printf("Usuario ...: %s%n", UtilesPassword.MSG_ERR_DIG_PASS);
        } else if (!validarStrPun(pass)) {
            System.out.printf("Usuario ...: %s%n", UtilesPassword.MSG_ERR_EXT_PASS);
        } else {
            System.out.printf("Usuario ...: %s%n", UtilesPassword.MSG_SUC_PASS);
        }

    }
}
