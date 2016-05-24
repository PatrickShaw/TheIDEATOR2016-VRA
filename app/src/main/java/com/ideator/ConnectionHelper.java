package com.ideator;

/**
 * @author Patrick Shaw (Patrick.Leong.Shaw@gmail.com)
 * @since {25/05/2016}
 */
public class ConnectionHelper {
    private static String username;
    public static String getUsername()
    {
        return username;
    }
    public static void setUsername(String username)
    {
        ConnectionHelper.username = username;
    }
    private static String password;
    public static String getPassword()
    {
        return password;
    }
    public static void setPassword(String password)
    {
        ConnectionHelper.password = password;
    }
}
