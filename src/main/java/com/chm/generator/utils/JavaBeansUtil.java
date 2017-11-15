/**
 * Copyright 2006-2017 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.chm.generator.utils;

import java.util.Locale;

/**
 * @author chen-hongmin
 */
public class JavaBeansUtil {

    private JavaBeansUtil() {

        super();
    }

    /**
     * Computes a getter method name.  Warning - does not check to see that the property is a valid
     * property.  Call getValidPropertyName first.
     *
     * @param property the property
     * @return the getter method name
     */
    public static String getGetterMethodName(String property, String javaType) {

        StringBuilder sb = new StringBuilder();

        sb.append(property);
        if (Character.isLowerCase(sb.charAt(0))) {
            if (sb.length() == 1 || !Character.isUpperCase(sb.charAt(1))) {
                sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            }
        }

        if ("boolean".equals(javaType)) {
            sb.insert(0, "is"); //$NON-NLS-1$
        } else {
            sb.insert(0, "get"); //$NON-NLS-1$
        }

        return sb.toString();
    }

    /**
     * Computes a setter method name.  Warning - does not check to see that the property is a valid
     * property.  Call getValidPropertyName first.
     *
     * @param property the property
     * @return the setter method name
     */
    public static String getSetterMethodName(String property) {

        StringBuilder sb = new StringBuilder();

        sb.append(property);
        if (Character.isLowerCase(sb.charAt(0))) {
            if (sb.length() == 1 || !Character.isUpperCase(sb.charAt(1))) {
                sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            }
        }

        sb.insert(0, "set"); //$NON-NLS-1$

        return sb.toString();
    }

    public static String getCamelCaseString(String inputString, boolean firstCharacterUppercase) {

        StringBuilder sb = new StringBuilder();

        boolean nextUpperCase = false;
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);

            switch (c) {
                case '_':
                case '-':
                case '@':
                case '$':
                case '#':
                case ' ':
                case '/':
                case '&':
                    if (sb.length() > 0) {
                        nextUpperCase = true;
                    }
                    break;

                default:
                    if (nextUpperCase) {
                        sb.append(Character.toUpperCase(c));
                        nextUpperCase = false;
                    } else {
                        sb.append(Character.toLowerCase(c));
                    }
                    break;
            }
        }

        if (firstCharacterUppercase) {

            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        }

        return sb.toString();
    }

    /**
     *
     * @param name
     * @return
     */
    public static String firstToLowerCase(String name) {

        char[] cs = name.toCharArray();
        cs[0] += 32;
        return String.valueOf(cs);

    }

    /**
     * This method ensures that the specified input string is a valid Java property name.
     * <p>
     * <p>The rules are as follows:
     * <p>
     * <ol>
     * <li>If the first character is lower case, then OK</li>
     * <li>If the first two characters are upper case, then OK</li>
     * <li>If the first character is upper case, and the second character is lower case, then the first character should be made
     * lower case</li>
     * </ol>
     * <p>
     * <p>For example:
     * <p>
     * <ul>
     * <li>eMail &gt; eMail</li>
     * <li>firstName &gt; firstName</li>
     * <li>URL &gt; URL</li>
     * <li>XAxis &gt; XAxis</li>
     * <li>a &gt; a</li>
     * <li>B &gt; b</li>
     * <li>Yaxis &gt; yaxis</li>
     * </ul>
     *
     * @param inputString the input string
     * @return the valid property name
     */
    public static String getValidPropertyName(String inputString) {

        String answer;

        if (inputString == null) {
            answer = null;
        } else if (inputString.length() < 2) {
            answer = inputString.toLowerCase(Locale.US);
        } else {
            if (Character.isUpperCase(inputString.charAt(0)) && !Character.isUpperCase(inputString.charAt(1))) {
                answer = inputString.substring(0, 1).toLowerCase(Locale.US) + inputString.substring(1);
            } else {
                answer = inputString;
            }
        }

        return answer;
    }
}
