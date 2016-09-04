public class Solution {
    private HashMap<String,ArrayList<String>> ticketMap = new HashMap<String,ArrayList<String>>();
    private int length;
    public List<String> findItinerary(String[][] tickets) {
        length = tickets.length+1;
        for(String[] trip:tickets){
            if(ticketMap.containsKey(trip[0])){
                //already have the depart airport
                ticketMap.get(trip[0]).add(trip[1]);
            }else{
                //new departure airport
                ArrayList<String> arr = new ArrayList<String>();
                arr.add(trip[1]);
                ticketMap.put(trip[0],arr);
            }
        }
        for(ArrayList<String> value:ticketMap.values()){
            Collections.sort(value);
        }
        
        //JFK is start airport
        ArrayList<String> itinerary = new ArrayList<String>();
        itinerary.add("JFK");
        search("JFK",itinerary);
        return itinerary;
    }
    public boolean search(String start,ArrayList<String> itinerary){
        if(itinerary.size()==length) return true;
        ArrayList<String> arr = ticketMap.get(start);//read the start's possible destination airport
        if(arr!=null){
            for(int i=0;i<arr.size();++i){
                String end = arr.get(i);
                itinerary.add(end);
                arr.remove(i);
                if(search(end,itinerary)==false){
                    itinerary.remove(itinerary.size()-1);
                    arr.add(i,end);
                }else{
                    return true;
                }
            }
            //return false; 
        }
        return false;
    }
}
