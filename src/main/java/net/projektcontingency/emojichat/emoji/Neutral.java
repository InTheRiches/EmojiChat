package net.projektcontingency.emojichat.emoji;

import net.projektcontingency.titanium.internal.Unicode;

public class Neutral extends Emoji {
    @Override
    public String getId() {
        return ":neutral:";
    }

    @Override
    public String getTextReplacement() {
        return ":|";
    }

    @Override
    public String getUnicode() {
        return Unicode.NEUTRAL.getText();
    }
}
