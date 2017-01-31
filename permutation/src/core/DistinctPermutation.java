package core;

import java.util.ArrayList;

public class DistinctPermutation {

	private static int count = 0;
	private static char[] p;
	private static String sequence;
	private static ArrayList<String> buffer = new ArrayList<String>();
	private static int[] used;

	public static void permutation(char[] vet) {

		used = new int[vet.length];
		for (int i = 0; i < used.length; i++)
			used[i] = 0;

		p = new char[vet.length];
		permutation(vet, 0, used);
		printBuffer();
	}

	private static void permutation(char[] vet, int n, int[] used) {

		if (n == vet.length) {
			count++;
			buffering();
		} else {
			for (int i = 0; i < vet.length; i++) {
				if (used[i] == 0) {
					p[n] = vet[i];
					used[i] = 1;
					permutation(vet, n + 1, used);
					used[i] = 0;
				}
			}
		}

	}

	private static void buffering() {
		sequence = "";
		for (int i = 0; i < p.length; i++) {
			sequence = sequence + p[i];
		}
		if (!buffer.contains(sequence))
			buffer.add(sequence);
	}

	private static void printBuffer() {
		count = 0;
		System.out.println();
		for (int i = 0; i < buffer.size(); i++) {
			count++;
			System.out.print("(" + count + ") : " + buffer.get(i));
			System.out.println();
		}
	}

	private static void print() {
		System.out.println();
		System.out.print("(" + count + ") : ");
		for (int i = 0; i < p.length; i++) {
			System.out.print(p[i] + " ");
		}
	}

}
