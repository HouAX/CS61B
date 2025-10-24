/*
*  Stimulate a universe specified in one of the data files.
*/
public class NBody {
    /*
    *  Return a double corresponding to the radius of the universe
    *  in that file.
    */
    public static double readRadius(String filename) {
        In in = new In(filename);
        int PlanetNumber = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    /*
    *  Return an array of planets in the file.
    */
    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        int PlanetNumber = in.readInt();
        Planet[] planets = new Planet[PlanetNumber];
        // jump over the radius
        in.readDouble();
        
        for (int i = 0; i < PlanetNumber; i ++) {
            planets[i] = new Planet(in.readDouble(), in.readDouble(),
                                    in.readDouble(), in.readDouble(),
                                    in.readDouble(), in.readString());
        }
        return planets;
    }
    
    /*
    *  Drawing the initial universe state.
    */
    public static void main(String[] args) {
        // collecting all needed input
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] Planets = readPlanets(filename);
        double Radius = readRadius(filename);

        // get the Planetnumber
        In in = new In(filename);
        int PlanetNumber = in.readInt();

        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-Radius, Radius);
        StdDraw.clear();

        double t = 0;
        while (t <= T) {
            double[] xForces = new double[PlanetNumber];
            double[] yForces = new double[PlanetNumber];
            for (int i = 0; i < PlanetNumber; i ++) {
                xForces[i] = Planets[i].calcNetForceExertedByX(Planets);
                yForces[i] = Planets[i].calcNetForceExertedByY(Planets);
                // Planets[i].update(dt, xForces[i], yForces[i]);
            }

            for (int i = 0; i < PlanetNumber; i ++) {
                Planets[i].update(dt, xForces[i], yForces[i]);
            }
            
            // drawing the background
            StdDraw.picture(0, 0, "images/starfield.jpg");
            
            // drawing all of the planets
            for (Planet planet : Planets) {
                planet.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            t += dt;
        }
        StdOut.printf("%d\n", Planets.length);
        StdOut.printf("%.2e\n", Radius);
        for (int i = 0; i < Planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            Planets[i].xxPos, Planets[i].yyPos, Planets[i].xxVel,
            Planets[i].yyVel, Planets[i].mass, Planets[i].imgFileName);   
        }
    }
}