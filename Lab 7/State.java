/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7;

/**
 *
 * @author kokarat
 */
public class State {
    int r;
    int c;
    int dist;
    int bombed;

    public State(int r, int c, int dist, int bombed) {
        this.r = r;
        this.c = c;
        this.dist = dist;
        this.bombed = bombed;
    }
}
