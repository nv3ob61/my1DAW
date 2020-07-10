/* 
 * Copyright 2019 José A. Pacheco Ondoño - joanpaon@gmail.com.
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

package org.japo.java.libraries;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public final class UtilesPassword {

    // Longitudes - user
    public static final int LEN_MIN_USER = 6;
    public static final int LEN_MAX_USER = 12;

    // Longitudes - pass
    public static final int LEN_MIN_PASS = 8;
    public static final int LEN_MAX_PASS = 16;

    public static final String REG_PASS = 
            String.format("((?=.*[a-z])(?=.*[0-9])(?=.*[_@#$~%&])(?=.*[A-Z]).{%d,%d})", 
                    LEN_MIN_PASS, LEN_MAX_PASS);
    public static final String REG_USER = 
            String.format("((?=.*[a-z])(?=.*[0-9])(?=.*[_@#$~%\\&])(?=.*[A-Z]).{%d,%d})", 
                    LEN_MIN_USER, LEN_MAX_USER);
}
