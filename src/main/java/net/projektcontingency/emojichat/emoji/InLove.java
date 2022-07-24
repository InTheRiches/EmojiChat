package net.projektcontingency.emojichat.emoji;

import net.projektcontingency.titanium.internal.Unicode;

public class InLove extends Emoji {
    @Override
    public String getId() {
        return ":in_love:";
    }

    @Override
    public String getTextReplacement() {
        return null;
    }

    @Override
    public String getUnicode() {
        return Unicode.IN_LOVE.getText();
    }
}
