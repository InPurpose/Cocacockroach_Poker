public enum YNP {
    YES,NO,PASS;

    public static YNP StringToYNP(String string)
    {
        if(string == "Yes")
            return YES;
        if(string == "No")
            return NO;
        if(string == "Pass")
            return PASS;

        return null;
    }
}
