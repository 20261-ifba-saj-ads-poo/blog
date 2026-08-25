void main() {
    Properties settings = new Properties();

    try (FileInputStream input = new FileInputStream("appsettings.properties")) {
        settings.load(input);

        String theme = settings.getProperty("theme", "light"); // Default to 'light'
        String language = settings.getProperty("language", "en"); // Default to 'en'
        int timeout = Integer.parseInt(settings.getProperty("timeout", "60")); // Default to 60 seconds

        IO.println("Theme: " + theme);
        IO.println("Language: " + language);
        IO.println("Timeout: " + timeout + " seconds");
    } catch (IOException | NumberFormatException e) {
        IO.println("Error loading application settings: " + e.getMessage());
    }

}
