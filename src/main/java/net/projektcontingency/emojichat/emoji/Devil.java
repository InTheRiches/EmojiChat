package net.projektcontingency.emojichat.emoji;

import net.projektcontingency.titanium.internal.Unicode;

public class Devil extends Emoji {
    @Override
    public String getId() {
        return ":devil:";
    }

    @Override
    public String getTextReplacement() {
        return null;
    }

    @Override
    public String getUnicode() {
        return Unicode.DEVIL.getText();
    }
}
