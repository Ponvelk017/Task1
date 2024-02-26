package task;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import inputcheck.InvalidInputException;
import util.Util;

public class JsonExample {
	public <E> JSONArray createJsonArray(List<E> values) throws InvalidInputException {
		Util.checkNull(values);
		JSONArray jsonArray = new JSONArray();
		for (Object value : values) {
			jsonArray.put(value);
		}
		return jsonArray;
	}

	public <E> JSONObject appendInJsonObj(String key, Object value, JSONObject jsonObj) throws InvalidInputException {
		Util.checkNull(key);
		Util.checkNull(value);
		jsonObj.put(key, value);
		return jsonObj;
	}

	public void printJsonObj(JSONObject object) throws InvalidInputException {
		Util.checkNull(object);
		for (String key : object.keySet()) {
			Object value = object.get(key);

			if (value instanceof JSONObject) {
				System.out.println("Key : " + key);
				for (String tempKey : ((JSONObject) value).keySet()) {
					System.out.println("  "+tempKey + " " + ((JSONObject) value).get(tempKey));
				}
			} else {
				System.out.println("Key : " + key + " value :" + value);
			}
		}
	}
}
