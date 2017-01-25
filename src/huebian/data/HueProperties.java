/*
 * Copyright (C) 2017 Markus
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package huebian.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

//import com.philips.lighting.hue.sdk.connection.impl.PHBridgeInternal;

/**
 * HueProperties.java
 * 
 * Stores the last known connected IP Address and the last known username.
 * This facilitates automatic bridge connection. 
 *  
 * Also, as the username (for the whitelist) is a random string,  this prevents the need to 
 * pushlink every time the app is started (as the username is read from the properties file).
 *
 */
public final class HueProperties {

    private static final String LAST_CONNECTED_IP   = "LastIPAddress";
    private static final String USER_NAME           = "WhiteListUsername";
    private static final String PROPS_FILE_NAME     = "MyHue.properties";
    private static Properties props=null;

    private HueProperties() {
    }
    
    public static void storeLastIPAddress(String ipAddress) {
        props.setProperty(LAST_CONNECTED_IP, ipAddress);
        saveProperties();
    }

    /**
     * Stores the Username (for Whitelist usage). This is generated as a random 16 character string.
     */
    public static void storeUsername(String username) {
        props.setProperty(USER_NAME, username);
        saveProperties();
    }

    /**
     * Returns the stored Whitelist username.  If it doesn't exist we generate a 16 character random string and store this in the properties file.
     */
    public static String getUsername() {
        String username = props.getProperty(USER_NAME);        
        return username;
    }

    public static String getLastConnectedIP() {
        return props.getProperty(LAST_CONNECTED_IP);
    }
    
    public static void loadProperties() {
        if (props==null) {
            props=new Properties();
            FileInputStream in;
            
            try {
                in = new FileInputStream(PROPS_FILE_NAME);
                props.load(in);
                in.close();
            } catch (FileNotFoundException ex) {
                saveProperties();
            } catch (IOException e) {
                // Handle the IOException.
            }
        }
    }

    public static void saveProperties() {
        try {
            FileOutputStream out = new FileOutputStream(PROPS_FILE_NAME);
            props.store(out, null);
            out.close();
        } catch (FileNotFoundException e) {
            // Handle the FileNotFoundException.
        } catch (IOException e) {
            // Handle the IOException.
        }
    } 

}