package main;

import java.util.*;

public class Defibrillators {

	public static void main(String[] args) {

		String LON = "3,879483";
		String LAT = "43,608177";
		int N = 3;

		List<String> defibList = new ArrayList<>();

		defibList.add("1;Maison de la Prevention Sante;6 rue Maguelone 340000 Montpellier;;3,87952263361082;43,6071285339217");
		defibList.add("2;Hotel de Ville;1 place Georges Freche 34267 Montpellier;;3,89652239197876;43,5987299452849");
		defibList.add("3;Zoo de Lunaret;50 avenue Agropolis 34090 Mtp;;3,87388031141133;43,6395872778854");

		List<Defi> defiList = new ArrayList<Defi>();

		for (String DEFIB : defibList) {
			String[] tmp = DEFIB.split(";");
			Defi defiTmp = new Defi();
			defiTmp.setName(tmp[1]);
			defiTmp.setLongB(Double.parseDouble(tmp[4].replace(",", ".")));
			defiTmp.setLatiB(Double.parseDouble(tmp[5].replace(",", ".")));
			defiList.add(defiTmp);
		}

		Double distance = null;
		String name = "";

		for (Defi defi : defiList) {
			double distanceTMP = getDistance(Double.parseDouble(LON.replace(",", ".")),
					Double.parseDouble(LAT.replace(",", ".")), defi.getLongB(), defi.getLatiB());
			if (distance == null) {
				distance = distanceTMP;
			}
			if (distanceTMP <= distance) {
				distance = distanceTMP;
				name = defi.getName();
			}
		}

		System.out.println(name);

		// System.out.println(getDistance(3.879483, 43.608177, 3.87952263361082,
		// 43.6071285339217));
		// System.out.println(getDistance(3.879483, 43.608177, 3.89652239197876,
		// 43.5987299452849));
		// System.out.println(getDistance(3.879483, 43.608177, 3.87388031141133,
		// 43.6395872778854));

	}

	private static double getDistance(double longA, double latiA, double longB, double latiB) {

		double y = latiB - latiA;
		double x = (longB - longA) * Math.cos(Math.toRadians((latiA + latiB) / 2));
		double result = Math.sqrt(Math.pow(y, 2) + Math.pow(x, 2)) * 6371;

		return result;
	}

	static class Defi {

		private String name;
		private Double longB;
		private Double latiB;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Double getLongB() {
			return longB;
		}

		public void setLongB(Double longB) {
			this.longB = longB;
		}

		public Double getLatiB() {
			return latiB;
		}

		public void setLatiB(Double latiB) {
			this.latiB = latiB;
		}

	}

}
