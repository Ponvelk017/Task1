package task;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import inputcheck.InvalidInputException;
import util.Util;

public class HashMapTask {

	public <K, V> Map<K, V> createHashMap() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
		Class<?> hashMapClass = Class.forName("java.util.HashMap");
		Constructor<?> hashMapConstructor = hashMapClass.getDeclaredConstructor();
		return (Map<K, V>) hashMapConstructor.newInstance();
	}

	public <K, V> Map<K, V> appendInMap(Map<K, V> input, K key, V value) throws InvalidInputException {
		Util.checkNull(input);
		input.put(key, value);
		return input;
	}
	
	public <K, V> int findLength(Map<K, V> input) throws InvalidInputException {
		Util.checkNull(input);
		return input.size();
	}

	public <K, V> boolean checkIfKeyPresents(Map<K, V> input, K elementToCheck) throws InvalidInputException {
		Util.checkNull(input);
		return input.containsKey(elementToCheck);
	}

	public <K, V> boolean checkIfValuePresents(Map<K, V> input, V elementToCheck) throws InvalidInputException {
		Util.checkNull(input);
		return input.containsValue(elementToCheck);
	}
	
	public <K, V> Map<K, V> replaceValues(Map<K, V> input, K key , V value)throws InvalidInputException {
		Util.checkNull(input);
		Util.checkNull(key);
		Util.checkNull(value);
		input.replace(key , value);
		return input;
	}

	public <K, V> Map<K, V> replaceConsecutiveValues(Map<K, V> input, List<V> values, int numberOfPairs) throws InvalidInputException {
		Util.checkNull(input);
		Util.checkNull(values);
		int loopIndex = 0;
		for (Entry entry : input.entrySet()) {
			if ((numberOfPairs--) > 0) {
				entry.setValue(values.get(loopIndex++));
			}
			else {
				break;
			}
		}
		return input;
	}

	public <K, V> V findElementByKey(Map<K, V> input, K keyElement) throws InvalidInputException {
		Util.checkNull(input);
		Util.checkNull(keyElement);
		return input.get(keyElement);
	}

	public <K, V> Object returnCustomIfNoKey(Map<K, V> input, K key, Object toReturn) throws InvalidInputException {
		Util.checkNull(input);
		Util.checkNull(key);
		Util.checkNull(toReturn);
		return input.getOrDefault(key, (V) toReturn);
	}

	public <K, V> Map<K, V> removeKeys(Map<K, V> input, K key) throws InvalidInputException {
		Util.checkNull(input);
		Util.checkNull(key);
		input.remove(key);
		return input;
	}

	public <K, V> Map<K, V> removeIfMatches(Map<K, V> input, K key, V value) throws InvalidInputException {
		Util.checkNull(input);
		Util.checkNull(key);
		Util.checkNull(value);
		input.remove(key, value);
		return input;
	}

	public <K, V> Map<K, V> replaceIfMatches(Map<K, V> input, K key, V value , V toReplace) throws InvalidInputException {
		Util.checkNull(input);
		Util.checkNull(key);
		Util.checkNull(value);
		Util.checkNull(toReplace);
		input.replace(key, value, toReplace);
		return input;
	}

	public <K, V> Map<K, V> mergeTwoMaps(Map<K, V> input1, Map<K, V> input2) throws InvalidInputException {
		Util.checkNull(input1);
		Util.checkNull(input2);
		input2.putAll(input1);
		return input1;
	}

	public <K, V> Iterator printMap(Map<K, V> input) throws InvalidInputException {
		Util.checkNull(input);
		Iterator<Map.Entry<K,V>> iterator = input.entrySet().iterator();
		return iterator;
	}

	public <K, V> Map<K, V> removeAll(Map<K, V> input) throws InvalidInputException {
		Util.checkNull(input);
		input.clear();
		return input;
	}

}
