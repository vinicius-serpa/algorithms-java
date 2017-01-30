package core;

import java.util.ArrayList;

public class DistinctPermutation {

	private static int count = 0;
	private static char[] p;
	private static String sequence;
	private static ArrayList<String> buffer = new ArrayList<String>();

	public static void permutation(char[] vet) {
		p = new char[vet.length];
		permutation(vet, 0);
		printBuffer();
	}

	private static void permutation(char[] vet, int n) {

		if (n == vet.length) {
			count++;
			print();
		} else {

			for (int i = 0; i < vet.length; i++) {

				boolean found = false;

				for (int j = 0; j < n; j++) {
					if (p[j] == vet[i])
						found = true;
				}

				if (!found) {
					p[n] = vet[i];
					permutation(vet, n + 1);
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
