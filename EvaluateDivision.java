class Solution {
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		HashMap<String, HashMap<String, Double>> graph = new HashMap<String, HashMap<String,Double>>();
		for (int i = 0; i < equations.size(); i++) {
			String from = equations.get(i).get(0);
			String to = equations.get(i).get(1);
			double cost = values[i];
			Double rev_cost = (1.0 / cost);
			if(graph.containsKey(from)==false)
				graph.put(from, new HashMap<String, Double>());
			HashMap<String, Double> nodes = graph.get(from);
			nodes.put(to, cost);
			///   reciprocal
			if(graph.containsKey(to)==false)
				graph.put(to, new HashMap<String, Double>());
			HashMap<String, Double> rec_node = graph.get(to);
			rec_node.put(from, rev_cost);
			///
		}
		double[] result = new double[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			String from = queries.get(i).get(0);
			if(graph.containsKey(from)==false)
			{
				result[i] = -1;
				continue;
			}
			String to = queries.get(i).get(1);
			if(from.equals(to))
			{
				result[i] = 1;
				continue;
			}
			HashSet<String> set = new HashSet<String>();
			set.add(from);
			double val = func(from,to,1.0,set,graph);
			result[i] = val;
		}
		return result;
    }
    private static double func(String from, String target, double cost, HashSet<String> visited, HashMap<String, HashMap<String, Double>> graph) {
		// get the points i can reach 
		Set<String> r_points = graph.get(from).keySet();
		for (String point : r_points) {
			if(visited.contains(point))
			{
				// if already visited then leave it 
				continue;
			}
			if(point.equals(target))
			{
				// if its target immediately return it
				return cost * graph.get(from).get(point);
			}
			else
			{
				// again dfs that point but update the set with that point
				visited.add(point);
				double newC = cost * graph.get(from).get(point);
				double toRet = func(point, target, newC, visited, graph);
				visited.remove(point);
				if(toRet!=-1)
				{
					return toRet;
				}
				else {
					continue;
				}
			}
		}
		return -1;
	}
}
