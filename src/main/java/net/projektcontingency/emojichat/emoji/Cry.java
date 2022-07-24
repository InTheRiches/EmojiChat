package net.projektcontingency.emojichat.emoji;

import net.projektcontingency.titanium.internal.Unicode;

public class Cry extends Emoji {
    @Override
    public String getId() {
        return ":cry:";
    }

    @Override
    public String getTextReplacement() {
        return ";(";
    }

    @Override
    public String getUnicode() {
        return Unicode.CRY.getText();
    }
}
