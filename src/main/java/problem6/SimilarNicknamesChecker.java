package problem6;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class SimilarNicknamesChecker {

    private final Set<String> capturedEmails = new HashSet<>();
    private final Map<String, String> nicknameKeyToEmail = new HashMap<>();
    public SimilarNicknamesChecker(List<List<String>> forms) {
        Validator.validate(forms);
        check(forms);
    }

    private void check(List<List<String>> forms) {
        for (var form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            captureSimilarNicknamesOf(email, nickname);
            store(email, nickname);
        }
    }

    private void captureSimilarNicknamesOf(String email, String nickname) {
        IntStream.range(0, nickname.length() - 1)
                .mapToObj(index -> nickname.substring(index, index + 2))
                .filter(nicknameKey -> nicknameKeyToEmail.containsKey(nicknameKey))
                .forEach(nicknameKey -> {
                    capturedEmails.add(email);
                    capturedEmails.add(nicknameKeyToEmail.get(nicknameKey));
                });
    }

    private void store(String email, String nickname) {
        IntStream.range(0, nickname.length() - 1)
                .mapToObj(index -> nickname.substring(index, index + 2))
                .forEach(nicknameKey -> nicknameKeyToEmail.put(nicknameKey, email));
    }

    public List<String> getEmailsOf() {
        List<String> result = new ArrayList<>(capturedEmails);

        Collections.sort(result);

        return result;
    }

    public static class Validator {
        private static final int CREW_NUMBER_LOWER_BOUNDS = 1;
        private static final int CREW_NUMBER_UPPER_BOUNDS = 10000;
        private static final String ERR_CREW_NUMBER = "크루의 수는 1 이상 10,000 이하입니다.";
        private static final String ERR_EMAIL_FORMAT =  "올바르지 않은 이메일 형식입니다.";
        private static final String ERR_NICKNAME_FORMAT = "올바르지 않은 닉네임 형식입니다.";

        public static void validate(List<List<String>> forms) {
            validateCrewNumber(forms);
            validateCrewInfo(forms);
        }

        private static void validateCrewNumber(List<List<String>> forms) {
            if (forms.size() < CREW_NUMBER_LOWER_BOUNDS
                    || forms.size() > CREW_NUMBER_UPPER_BOUNDS) {
                throw new IllegalArgumentException(ERR_CREW_NUMBER);
            }
        }

        private static void validateCrewInfo(List<List<String>> forms) {
            for (List<String> crew : forms) {
                validateEmail(crew.get(0));
                validateNickname(crew.get(1));
            }
        }

        private static void validateEmail(String email) {
            Pattern emailPattern = Pattern.compile("^[a-zA-z0-9]{1,9}@email\\.com$");
            Matcher matcher = emailPattern.matcher(email);
            if (!matcher.matches()) {
                throw new IllegalArgumentException(ERR_EMAIL_FORMAT);
            }
        }

        private static void validateNickname(String nickname) {
            Pattern nicknamePattern = Pattern.compile("^[가-힣]{1,19}$");
            Matcher matcher = nicknamePattern.matcher(nickname);
            if (!matcher.matches()) {
                throw new IllegalArgumentException(ERR_NICKNAME_FORMAT);
            }
        }
    }
}