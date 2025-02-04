package com.andredonadon.string;

public class RunLengthEncoding {

    public static String encode(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder encoded = new StringBuilder();
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                encoded.append( input.charAt(i -1) ).append(count);
                count = 1;
            }
        }

        encoded.append(input.charAt(input.length() - 1)).append(count);

        return encoded.toString();
    }

    public static String decode(String encoded) {
        if (encoded == null || encoded.isEmpty()) {
            return "";
        }

        StringBuilder decoded = new StringBuilder();

        for (int i = 0; i < encoded.length(); i++) {
            char character = encoded.charAt(i);
            int count = 0;

            while ( (i+1 < encoded.length()) && (Character.isDigit(encoded.charAt(i+1)))) {
                count = count * 10 + (encoded.charAt(++i)) - '0';
            }

            decoded.append(String.valueOf(character).repeat(count));
        }

        return decoded.toString();
    }

    private static String reduced(String input) {
        if ((input == null) || input.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(input.charAt(0));

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) != input.charAt(i-1)) {
                sb.append(input.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String original = "aannndrrrrreeeee lluuuiiiizzzzzzz";
        String compressed = encode(original);
        String reduced = reduced(original);
        String decompressed = decode(compressed);

        System.out.println("Original:    " + original);
        System.out.println("Compactado:  " + compressed);
        System.out.println("Reduzido:  " + reduced);
        System.out.println("Descompactado: " + decompressed);
    }

}
