package code.homework3.adapter;

public class JsonCsvDataAdapter extends CsvData {
    public JsonCsvDataAdapter(String text) {
        super(parseJsonToCsvDataFormat(text));
    }

    private static String parseJsonToCsvDataFormat(String jsonData) {
        return jsonData.replace("{", "")
                .replace("}", "")
                .replace("\"", "")
                .replace(",", "")
                .replace(":", ",");
    }
}
