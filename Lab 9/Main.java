/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9;

/**
 *
 * @author kokarat
 */
import java.util.ArrayList;
import java.util.Scanner;

class Particle {
    int id;
    int energy;

    public Particle(int id, int energy) {
        this.id = id;
        this.energy = energy;
    }
}

class CollisionSimulator {
    private ArrayList<Particle> particles;

    public CollisionSimulator(ArrayList<Particle> particles) {
        this.particles = particles;
    }

    public long simulate() {
        long totalEnergy = 0;

        while (particles.size() > 1) {
            int maxDiff = -1;
            int bestIndex = -1;
            int minId = Integer.MAX_VALUE;

            for (int i = 0; i < particles.size() - 1; i++) {
                int diff = Math.abs(particles.get(i).energy - particles.get(i + 1).energy);
                int currentMinId = Math.min(particles.get(i).id, particles.get(i + 1).id);

                if (diff > maxDiff) {
                    maxDiff = diff;
                    bestIndex = i;
                    minId = currentMinId;
                } else if (diff == maxDiff) {
                    if (currentMinId < minId) {
                        bestIndex = i;
                        minId = currentMinId;
                    }
                }
            }

            if (bestIndex != -1) {
                totalEnergy += maxDiff;
                particles.remove(bestIndex + 1);
                particles.remove(bestIndex);
            }
        }
        return totalEnergy;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            ArrayList<Particle> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                list.add(new Particle(i, scanner.nextInt()));
            }
            CollisionSimulator simulator = new CollisionSimulator(list);
            System.out.println(simulator.simulate());
        }
        scanner.close();
    }
}