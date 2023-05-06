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
    private isAngolszasz: boolean

    constructor(cel: string, tavolsag: number, isAngolszasz: boolean) {
        this.cel = cel
        this.tavolsag = tavolsag
        this.isAngolszasz = isAngolszasz
    }

    getTavolsag(): number {
        if (this.isAngolszasz) {
            return this.tavolsag * 1.6
        } else {
            return this.tavolsag;
        }

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
    private utazasok: Utazas[]

    constructor(nev: string) {
        this.nev = nev;
        this.utazasok = new Array<Utazas>();
    }

    setNev(nev: string): void {
        this.nev = nev;
    }

    addUtazas(utazas: Utazas) {
        this.utazasok.push(utazas)
    }

    getTravelLength(): number {
        let result: number = 0;
        // for (let i = 0; i < this.utazasok.length; i++) {
        //     result += this.utazasok[i].getTavolsag()
        // }
        for (let utazas of this.utazasok) {
            result += utazas.getTavolsag()
        }
        return result;
    }
}

let robi: Alkalmazott = new Alkalmazott("Róbert");
let peti: Alkalmazott = new Alkalmazott("Péter");
robi.setNev("Bárdonicsek Róbert")
peti.setNev("lssfffééj")
let utazas1 = new Utazas("Budapest", 550, true);
let utazas2 = new Utazas("Pécs", 60, false);
let utazas3 = new Utazas("Balaton", 300, false);

robi.addUtazas(utazas1);
robi.addUtazas(utazas2);
robi.addUtazas(utazas3);

let alkalmazott = {
    "nev": "Robi",
    "utazasai": [
        {
            "cel": "Budapest",
            "tavolsag": 550,
            "utazasiIroda": "Valami Travel",
        },
        {
            "cel": "Korfu",
            "utazasiIroda": "Valami Travel",
            "tavolsag": 3400
        }
    ]
}

for (let key in alkalmazott.utazasai[1]) {
    console.log(key + " : " + alkalmazott.utazasai[1][key])
}

//terfogatLista.push(100)
kutya[0] = 100
//console.log(nev);
nev = "Józsi"

// console.log("terfogatLista:" + terfogatLista);
// console.log("kutya:" + kutya);
console.log(robi.getTravelLength());