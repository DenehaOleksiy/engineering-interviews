import java.util.*;

/**
 * Created by Администратор on 26.09.2016.
 */
public class Puzzle {

    // використовуємо якщо ми знаємо, що вихідне значення є суммою вхідних значень
            	public static Map<Double, List<Double>> showComprised(List<Double> in, List<Double> out) {
        		if (in == null || out == null)
            			throw new IllegalArgumentException("Arguments must not be null");
        		Map<Double, List<Double>> comprisedMap = new LinkedHashMap<>();

                		for (int i = 0; i < out.size(); i++) {
            			double sum = out.get(i);

                    			for (int k = 0; k < in.size() - 1; k++) {
                				double firstNumber = in.get(k);
                				double secondNumber = sum - firstNumber;

                        				if (secondNumber == 0)
                    					comprisedMap.put(sum, new ArrayList<>(Arrays.asList(firstNumber)));

                        				for (int j = k + 1; j < in.size(); j++) {
                    					if (in.get(j) == secondNumber) {
                        						comprisedMap.put(sum, new ArrayList<>(Arrays.asList(firstNumber, secondNumber)));
                        						break;
                        					}
                    				}
                			}
            		}

                		return comprisedMap;
        	}

    // використовуємо якщо ми не знаємо скільки вхідних значень містить вихідне значення
    	       	public static Map<Double, List<Double>> showComprised2(List<Double> in, List<Double> out) {
        		if (in == null || out == null)
            			throw new IllegalArgumentException("Arguments must not be null");
        		Map<Double, List<Double>> comprisedMap = new LinkedHashMap<>();

                		Collections.sort(in);
        		for (int i = 0; i < out.size(); i++) {
            			double outValue = out.get(i);
            			double sum = outValue;
            			List<Double> comprisedNumbers = new ArrayList<>();
            			int startPosition = 0;
                    			for (int k = startPosition; k < in.size(); k++) {
                				double inValue = in.get(k);
                				if ((sum - inValue) > inValue) {
                    					sum -= inValue;
                    					comprisedNumbers.add(inValue);
                    				} else if (sum - inValue == 0) {
                    					comprisedNumbers.add(inValue);
                    					comprisedMap.put(outValue, comprisedNumbers);
                    					break;
                    				} else {
                    					k = startPosition++;
                    					sum = outValue;
                    					comprisedNumbers = new ArrayList<>();
                    				}
                			}
            		}

                		return comprisedMap;
        	}

    public static void main(String[] args) {

        long start = System.nanoTime();
        Map<Double, List<Double>> comprised = showComprised2(new ArrayList<>(Arrays.asList(100.0, 100.0, 225.0, 300.0, 473.0, 80.0)),
                new ArrayList<>(Arrays.asList(180.0, 773.0, 225.0, 100.0)));
        System.out.println(System.nanoTime() - start);
        Set<Map.Entry<Double, List<Double>>> entrySet = comprised.entrySet();
        for (Map.Entry<Double, List<Double>> entry : entrySet) {

            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
    }
}
