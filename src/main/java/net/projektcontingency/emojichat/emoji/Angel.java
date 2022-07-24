package net.projektcontingency.emojichat.emoji;

import net.projektcontingency.titanium.internal.Unicode;

public class Angel extends Emoji {
    @Override
    public String getId() {
        return ":angel:";
    }

    @Override
    public String getTextReplacement() {
        return null;
    }

    @Override
    public String getUnicode() {
        return Unicode.ANGEL.getText();
    }
}
