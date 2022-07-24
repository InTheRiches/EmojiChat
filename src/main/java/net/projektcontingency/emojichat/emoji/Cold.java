package net.projektcontingency.emojichat.emoji;

import net.projektcontingency.titanium.internal.Unicode;

public class Cold extends Emoji {
    @Override
    public String getId() {
        return ":cold:";
    }

    @Override
    public String getTextReplacement() {
        return null;
    }

    @Override
    public String getUnicode() {
        return Unicode.COLD.getText();
    }
}
