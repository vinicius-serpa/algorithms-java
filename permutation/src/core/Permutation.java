package core;

// P(n) = n!
// P(3) = 3 x 2 x 1 = number of combinations
// P(4) = 4 x 3 x 2 x 1 = number of combinations
// n = number of elements
public class Permutation {

	private static int count = 0;
	private static char[] p;

	public static void permutation(char[] vet) {
		p = new char[vet.length];
		permutation(vet, 0);
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

	private static void allPermutation(char[] vet, int n) {
		if (n == vet.length) {
			count++;
			print();
		} else {
			for (int i = 0; i < vet.length; i++) {
				p[n] = vet[i];
				allPermutation(vet, n + 1);
			}
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
