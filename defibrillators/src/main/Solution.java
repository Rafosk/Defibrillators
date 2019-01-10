package main;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String LON = in.next();
        String LAT = in.next();
        System.err.println("LON: " + LON);
        System.err.println("LAT: " + LAT);
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        System.err.println("N: " + N);
        
        List<Defi> defiList = new ArrayList<Defi>();
        
        for (int i = 0; i < N; i++) {
            String DEFIB = in.nextLine();
            String[] tmp = DEFIB.split(";");
			Defi defiTmp = new Defi();
			defiTmp.setName(tmp[1]);
			defiTmp.setLongB(Double.parseDouble(tmp[4].replace(",", ".")));
			defiTmp.setLatiB(Double.parseDouble(tmp[5].replace(",", ".")));
			defiList.add(defiTmp);
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

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