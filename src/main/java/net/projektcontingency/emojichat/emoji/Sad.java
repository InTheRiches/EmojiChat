package net.projektcontingency.emojichat.emoji;

import net.projektcontingency.titanium.internal.Unicode;

public class Sad extends Emoji {
    @Override
    public String getId() {
        return ":sad:";
    }

    @Override
    public String getTextReplacement() {
        return ":(";
    }

    @Override
    public String getUnicode() {
        return Unicode.SAD.getText();
    }
}
