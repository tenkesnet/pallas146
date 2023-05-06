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
    function Utazas() {
        this.cel = "";
        this.tavolsag = 0;
    }
    return Utazas;
}());
var Alkalmazott = /** @class */ (function () {
    function Alkalmazott() {
        this.nev = "";
        this.utazasai = [];
    }
    Alkalmazott.prototype.setNev = function (nev) {
        this.nev = nev;
    };
    return Alkalmazott;
}());
var robi = new Alkalmazott();
var peti = new Alkalmazott();
robi.setNev("Bárdonicsek Róbert");
peti.
    peti.setNev("lkjlééj");
robi.utazasai.push(new Utazas());
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
console.log(osszead(terfogatLista));
