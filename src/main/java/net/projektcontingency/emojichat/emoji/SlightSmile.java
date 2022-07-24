package net.projektcontingency.emojichat.emoji;

import net.projektcontingency.titanium.internal.Unicode;

public class SlightSmile extends Emoji {
    @Override
    public String getId() {
        return ":slight_smile:";
    }

    @Override
    public String getTextReplacement() {
        return ":)";
    }

    @Override
    public String getUnicode() {
        return Unicode.SLIGHT_SMILE.getText();
    }
}
