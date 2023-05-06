// 1,2,567,-3,-78
// 1.6, 0.5,-3.6
// true, false
//camelCase motorTerfogatSzam 
//PascalCase MotorTerfogat
//underscore_case motor_terfogat
var terfogat = 50;
var uvegTerfogat = terfogat;
terfogat = 100;
var nev = "Robi";
var terfogatLista = [23, 78, 56.8];
var kutya = terfogatLista;
function osszead(tomb) {
    var result = 0;
    for (var _i = 0, tomb_1 = tomb; _i < tomb_1.length; _i++) {
        var item = tomb_1[_i];
        result = result + item;
    }
    //console.log(item);
    return result;
}
var Utazas = /** @class */ (function () {
    function Utazas(cel, tavolsag) {
        this.cel = cel;
        this.tavolsag = tavolsag;
    }
    Utazas.prototype.print = function () {
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
                return "Hosszú utazás";
        }
    };
    return Utazas;
}());
var Alkalmazott = /** @class */ (function () {
    function Alkalmazott(nev) {
        this.nev = nev;
        this.utazasai = new Array();
    }
    Alkalmazott.prototype.setNev = function (nev) {
        this.nev = nev;
    };
    Alkalmazott.prototype.addUtazas = function (utazas) {
        this.utazasai.push(utazas);
    };
    return Alkalmazott;
}());
var robi = new Alkalmazott("Róbert");
var peti = new Alkalmazott("Péter");
robi.setNev("Bárdonicsek Róbert");
peti.setNev("lssfffééj");
var utazas1 = new Utazas("Budapest", 550);
var utazas2 = new Utazas("Pécs", 60);
var utazas3 = new Utazas("Balaton", 300);
robi.addUtazas(utazas1);
var alkalmazott = {
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
};
//terfogatLista.push(100)
kutya[0] = 100;
//console.log(nev);
nev = "Józsi";
// console.log("terfogatLista:" + terfogatLista);
// console.log("kutya:" + kutya);
console.log(utazas2.print());
//# sourceMappingURL=pelda.js.map