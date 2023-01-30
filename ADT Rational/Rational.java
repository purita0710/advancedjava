public class Rational{
    private int numerator;
    private int denomiator;

    public Rational(){
        this.numerator = 0;
        this.denomiator=1;
    }

    public Rational (int x,int y){
        if (y == 0) {
            throw new ArithmeticException("Denominator is zero!!!");
        }

        int g = gcd(x,y);
        this.numerator = x/g;
        this.denomiator = y/g;
    }

    public void setNumerator(int num){
         this.numerator = num;
    }
    public void setDenomiator(int den){
        this.denomiator = den;

    }
    public void set(int num, int den){
        this.numerator = num;
        this.denomiator = den;
    }

    public int getNumerator(Rational rational){
        return this.numerator;
    }

    public int getDenomiator(Rational rational){
        return this.denomiator;
    }

    public float get(Rational rational){
        float result = getNumerator(rational)/getDenomiator(rational);
        return result;
    }

    // 기약분수를 만들기 위한 최대공약수 구하는 메소드
    public static int gcd(int a, int b) {
		if(a%b == 0) {
			return b;
		}
		return gcd(b, a%b);
	}

    // 더하기,빼기 연산을 하기 위한 공통분모 만들기>>최소공배수 메소드
    public static int lcm(Rational r, int gcd){
        int result = (r.getNumerator(r)*r.getDenomiator(r))/gcd;
        return result;
    }

    // 역수 만들기
    public Rational reciprocal(Rational r){
        int x = getDenomiator(r);
        int y = getNumerator(r);

        return new Rational(x, y);
    }

    public Rational divide(Rational r1,Rational r2){
        r2 = reciprocal(r2);
        Rational result = multiply(r1, r2);

        return result;
    }

    // 더하기 계산
    public Rational add(Rational r1,Rational r2){
        int den = gcd(getDenomiator(r1),getDenomiator(r2));
        int num = getNumerator(r1)*(den/getDenomiator(r1))+getNumerator(r2)*(den/getDenomiator(r2));

        return new Rational(num,den);
    }

    // 빼기 계산
    public Rational substract(Rational r1,Rational r2){
        int den = gcd(getDenomiator(r1),getDenomiator(r2));
        int num = getNumerator(r1)*(den/getDenomiator(r1))-getNumerator(r2)*(den/getDenomiator(r2));

        return new Rational(num,den);

    }

    // 곱하기 계산
    public Rational multiply(Rational r1,Rational r2){
        int x = getNumerator(r1)*getNumerator(r2);
        int y = getDenomiator(r1)*getDenomiator(r2);

        return new Rational(x, y);
    }

    // 제곱계산
    public Rational exponent(Rational r1, int a){
        int x=1,y=1;
        for(int i = 0;i<a;i++){
            x*=r1.getNumerator(r1);
        }
        for(int i = 0;i<a;i++){
            y*=r1.getDenomiator(r1);
        }

        return new Rational(x,y);
    }
    

       public boolean equal(Rational r1,Rational r2){
        if(r1==r2) return true;
        else return false;
    }


    
}

class Test{
    public static void main(String[] args) {
        Rational x,y,z;

        x=new Rational(1,6);
        y=new Rational(5,6);
       
        z=x.add(x,y);
        Rationalprint(z);

        x.set(3,6);
        y.set(2,6);
        z=x.substract(x,y);
        Rationalprint(z);

        x.set(3,6);
        y.set(2,6);
        z=x.multiply(x,y);
        Rationalprint(z);

        boolean a;
        x.set(3,6);
        y.set(2,6);
        a=x.equal(x,y);
        System.out.println(a);

        x.set(1,2);
        z=x.exponent(x, 3);
        Rationalprint(z);

        x.set(3,6);
        y.set(2,6);
        z=x.divide(x,y);
        Rationalprint(z);



    }

    public static void Rationalprint(Rational rational){
        System.out.print("Numerator: "+rational.getNumerator(rational)+" Denomiator: "+rational.getDenomiator(rational)+"\n");
    }
}