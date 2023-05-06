// 1,2,567,-3,-78
// 1.6, 0.5,-3.6
// true, false
//camelCase motorTerfogatSzam 
//PascalCase MotorTerfogat
//underscore_case motor_terfogat
let terfogat: number = 50;
let uvegTerfogat: number = terfogat;
terfogat = 100;
let nev: String = "Robi"

let terfogatLista: number[] = [23, 78, 56.8]
let kutya = terfogatLista


function osszead(tomb: number[]): number {
    let result: number = 0
    for (let item of tomb) {
        result = result + item;
    }
    //console.log(item);
    return result;
}

class Utazas {
    private cel: string
    private tavolsag: number

    constructor(cel: string, tavolsag: number) {
        this.cel = cel
        this.tavolsag = tavolsag
    }

    print(): string {
        // if (this.tavolsag >= 100 && this.tavolsag <= 300) {
        //     return "Közepes kirándulas"
        // } else if (this.tavolsag < 100) {
        //     return "Rövid kirándulás"
        // } else {
        //     return "Hosszú utazás"
        // }
        switch (true) {
            case this.tavolsag >= 100 && this.tavolsag <= 300:
                return "Közepes kirándulas";
                break;
            case this.tavolsag < 100:
                return "Rövid kirándulás";
                break;
            default:
                return "Hosszú utazás"

        }
    }
}

class Alkalmazott {
    private nev: String
    private utazasai: Utazas[]

    constructor(nev: string) {
        this.nev = nev;
        this.utazasai = new Array<Utazas>();
    }

    setNev(nev: string): void {
        this.nev = nev;
    }

    addUtazas(utazas: Utazas) {
        this.utazasai.push(utazas)
    }
}

let robi: Alkalmazott = new Alkalmazott("Róbert");
let peti: Alkalmazott = new Alkalmazott("Péter");
robi.setNev("Bárdonicsek Róbert")
peti.setNev("lssfffééj")
let utazas1 = new Utazas("Budapest", 550);
let utazas2 = new Utazas("Pécs", 60);
let utazas3 = new Utazas("Balaton", 300);

robi.addUtazas(utazas1);

let alkalmazott = {
    "nev": "Robi",
    "utazasai": [
        {
            cel: "Budapest",
            tavolsag: 550
        },
        {
            cel: "Korfu",
            "utazasiIroda": "Valami Travel",
            "tavolsag": 3400
        }
    ]
}

//terfogatLista.push(100)
kutya[0] = 100
//console.log(nev);
nev = "Józsi"

// console.log("terfogatLista:" + terfogatLista);
// console.log("kutya:" + kutya);
console.log(utazas2.print());