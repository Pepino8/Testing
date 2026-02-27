package mx.edu.cetys.software_quality_lab.validators;

public class EmailValidatorService {

    public boolean isValid(String email) {
        if (email == null || email.isEmpty()) return false;

        // Regla 6
        if (email.length() > 47) return false;

        // Regla 7
        if (!email.contains("4")) return false;

        // Regla 3
        if (!email.contains("#")) return false;

        // Si no tiene muerte
        if (!email.contains(".")) return false;

        // Si hay mas de 1 muerte
        if (email.indexOf("#") != email.lastIndexOf("#")) return false;

        //Si no hay 2 partes en el correo muerte
        String[] parts = email.split("#");

        String user = parts[0];
        String providerAndDomain = parts[1];

        // Si user esta vacio muerte
        if (user.isEmpty()) return false;

        int lastDotIndex = providerAndDomain.lastIndexOf(".");
        String provider = providerAndDomain.substring(0, lastDotIndex);
        String domain = providerAndDomain.substring(lastDotIndex + 1);

        // Regla 5
        if (domain.isEmpty() || domain.length() > 5) return false;

        // Si el proveedor esta vacio muerte
        if (provider.isEmpty()) return false;

        // Regla 1 + 2
        if (!user.matches("[a-z0-9.\\-_+]+")) return false;

        // Regla 2.1
        //if (!providerAndDomain.matches("[a-z0-9.]+")) return false;

        // Regla 4: sin diptongo (dos vocales consecutivas)
        String vocals = "aeiou";
        for (int i = 0; i < email.length() - 1; i++) {
            char curr = email.charAt(i);
            char next = email.charAt(i + 1);
            if (vocals.indexOf(curr) >= 0 && vocals.indexOf(next) >= 0) {
                return false;
            }
        }

        return true;
    }
}
