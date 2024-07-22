import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class EmojiDemo {
    public static void main(String[] args) {
        String messageWithEmoji = "Hello Java 21! 😄";
        String messageWithoutEmoji = "Hello Java!";
        System.out.println("Testing isEmoji():");
        System.out.println(messageWithEmoji.codePoints().anyMatch(Character::isEmoji) ? "Contains emoji" : "No emoji");
        System.out.println(messageWithoutEmoji.codePoints().anyMatch(Character::isEmoji) ? "Contains emoji" : "No emoji");
        System.out.println("\nTesting isEmojiPresentation():");
        System.out.println(messageWithEmoji.codePoints().anyMatch(Character::isEmojiPresentation) ? "Contains emoji presentation" : "No emoji presentation");
        System.out.println(messageWithoutEmoji.codePoints().anyMatch(Character::isEmojiPresentation) ? "Contains emoji presentation" : "No emoji presentation");
        System.out.println("\nTesting isEmojiModifier():");
        System.out.println(Character.isEmojiModifier(0x1F3FB) ? "Light skin tone is an emoji modifier" : "Not an emoji modifier");
        System.out.println(Character.isEmojiModifier(0x1F3FD) ? "Medium skin tone is an emoji modifier" : "Not an emoji modifier");
        System.out.println(Character.isEmojiModifier(0x1F3FF) ? "Dark skin tone is an emoji modifier" : "Not an emoji modifier");
        System.out.println("\nTesting isEmojiModifierBase():");
        System.out.println(Character.isEmojiModifierBase(Character.codePointAt("👍", 0)) ? "👍 is an emoji modifier base" : "Not an emoji modifier base");
        System.out.println(Character.isEmojiModifierBase(Character.codePointAt("👶", 0)) ? "👶 is an emoji modifier base" : "Not an emoji modifier base");
        System.out.println(Character.isEmojiModifierBase(Character.codePointAt("🍕", 0)) ? "🍕 is an emoji modifier base" : "Not an emoji modifier base");
        System.out.println("\nTesting isEmojiComponent():");
        System.out.println(Character.isEmojiComponent(0x200D) ? "Zero width joiner is an emoji component" : "Not an emoji component");
        System.out.println(Character.isEmojiComponent(0x1F3FD) ? "Medium skin tone is an emoji component" : "Not an emoji component");
        System.out.println("\nTesting isExtendedPictographic():");
        System.out.println(Character.isExtendedPictographic(Character.codePointAt("☀️", 0)) ? "☀️ is an extended pictographic" : "Not an extended pictographic");
        System.out.println(Character.isExtendedPictographic(Character.codePointAt("✔️", 0)) ? "✔️ is an extended pictographic" : "Not an extended pictographic");
        System.out.println("\nTesting regular expressions:");
        Pattern emojiPattern = Pattern.compile("\\p{IsEmoji}");
        Matcher isEmojiMatcher = emojiPattern.matcher(messageWithEmoji);
        System.out.println(isEmojiMatcher.find() ? "Message with emoji contains emojis" : "Message with emoji does not contain emojis");
        isEmojiMatcher = emojiPattern.matcher(messageWithoutEmoji);
        System.out.println(isEmojiMatcher.find() ? "Message without emoji contains emojis" : "Message without emoji does not contain emojis");
    }
}
