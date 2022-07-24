package net.projektcontingency.emojichat.emoji;

import net.projektcontingency.titanium.internal.Unicode;

public class Smile extends Emoji {
    @Override
    public String getId() {
        return ":smile:";
    }

    @Override
    public String getTextReplacement() {
        return null;
    }

    @Override
    public String getUnicode() {
        return Unicode.SMILE.getText();
    }
}
