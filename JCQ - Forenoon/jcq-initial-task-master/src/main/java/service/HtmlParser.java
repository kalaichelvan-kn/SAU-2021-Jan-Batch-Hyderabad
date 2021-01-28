package service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlParser {
    private String htmlContent;
    public HtmlParser(String htmlContent) {
        this.htmlContent = htmlContent;
    }
    public String getTitle() {
        try {
            final Pattern pattern = Pattern
                    .compile("<title>(.+?)</title>", Pattern.DOTALL);
            final Matcher matcher = pattern.matcher(this.htmlContent);
            matcher.find();
            return matcher.group(1);
        } catch(Exception e) {
            System.out.println("exception in regex"+e);
            return null;
        }
    }
}
