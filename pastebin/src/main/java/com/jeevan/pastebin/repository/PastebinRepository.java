

@Repository
public class PastebinRepository {
    // This class can be used to interact with the database or data storage for pastes.
    // For now, it can be left empty or contain methods to save and retrieve pastes.

    HashMap<String, String> pasteStorage = new HashMap<>();

    public String save(String content) {
        // Generate a unique ID for the paste
        String pasteId = UUID.randomUUID().toString();
        // Store the content in the HashMap with the generated ID
        pasteStorage.put(pasteId, content);
        return pasteId;
    }

    public String get(String pasteId) {
        // Retrieve the content associated with the given paste ID
        return pasteStorage.get(pasteId);
    }
}