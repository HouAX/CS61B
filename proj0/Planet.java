public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    /* Calculate the distance between two planets */
    public double calcDistance(Planet p) {
        double dx = p.xxPos - this.xxPos;
        double dy = p.yyPos - this.yyPos;
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance;
    }

    /* Calculate the force exerted by the given planet */
    public double calcForceExertedBy(Planet p) {
        double F = (G * this.mass * p.mass) / Math.pow(this.calcDistance(p), 2);
        return F;
    }

    /* Calculate the force exerted in the X directions */
    public double calcForceExertedByX(Planet p) {
        double dx = p.xxPos - this.xxPos;
        double F_x = this.calcForceExertedBy(p) * dx / this.calcDistance(p);
        return F_x;
    }

    /* Calculate the force exerted in the Y directions */
    public double calcForceExertedByY(Planet p) {
        double dy = p.yyPos - this.yyPos;
        double F_y = this.calcForceExertedBy(p) * dy / this.calcDistance(p);
        return F_y;
    }

    /* Net force version */
    public double calcNetForceExertedByX(Planet[] planets) {
        double NetForce_x = 0;
        for (Planet planet : planets) {
            if (this.equals(planet)) {
                continue;
            }
            NetForce_x += this.calcForceExertedByX(planet);
        }
        return NetForce_x;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double NetForce_y = 0;
        for (Planet planet : planets) {
            if (this.equals(planet)) {
                continue;
            }
            NetForce_y += this.calcForceExertedByY(planet);
        }
        return NetForce_y;
    }

    /* update position and velocity without return anything */
    public void update(double dt, double fx, double fy) {
        double ax = fx / this.mass;
        double ay = fy / this.mass;
        this.xxVel += dt * ax;
        this.yyVel += dt * ay;
        this.xxPos += dt * this.xxVel;
        this.yyPos += dt * this.yyVel;
    }

    /* Draw the planet using the StdDraw. */
    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}