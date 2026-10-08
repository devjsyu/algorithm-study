class Solution {
    public String maskPII(String s) {
        if (Character.isLetter(s.charAt(0))) {
            return maskEmail(s);
        } else {
            return maskPhoneNumber(s);
        }
    }

    private String maskEmail(String s) {
        StringBuilder sb = new StringBuilder();
        String[] parts = s.split("@");
        sb.append(Character.toLowerCase(parts[0].charAt(0)));
        sb.append("*****");
        sb.append(Character.toLowerCase(parts[0].charAt(parts[0].length() - 1)));
        sb.append("@");
        sb.append(parts[1].toLowerCase());

        return sb.toString();
    }

    private String maskPhoneNumber(String s) {
        StringBuilder sb = new StringBuilder();

        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if ("+-() ".contains(String.valueOf(s.charAt(i)))) {
                continue;
            }

            count++;

            if (count > 0 && count <= 4) {
                sb.append(s.charAt(i));
            }
        }

        String localNumber = sb.reverse().toString();
        sb.setLength(0);

        switch (count) {
            case 10 :
                break;
            case 11 :
                sb.append("+*-");
                break;
            case 12 :
                sb.append("+**-");
                break;
            case 13 :
                sb.append("+***-");
                break;
        }

        sb.append("***-***-");
        sb.append(localNumber);
        
        return sb.toString();
    }
}