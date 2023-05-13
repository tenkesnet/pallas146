var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
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
var szin = 300;
var terfogatLista = [23, 78, 56.8];
var kutya = terfogatLista;
var b = {
    x: 10
};
var macska = {
    nev: "Cirmi"
};
macska.nev = "Kormi";
console.log(macska);
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
    function Utazas(cel, tavolsag, isAngolszasz) {
        this.cel = cel;
        this.tavolsag = tavolsag;
        this.isAngolszasz = isAngolszasz;
    }
    Utazas.prototype.getTavolsag = function () {
        if (this.isAngolszasz) {
            return this.tavolsag * 1.6;
        }
        else {
            return this.tavolsag;
        }
    };
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
        this.utazasok = new Array();
    }
    Alkalmazott.prototype.setNev = function (nev) {
        this.nev = nev;
    };
    Alkalmazott.prototype.addUtazas = function (utazas) {
        this.utazasok.push(utazas);
    };
    Alkalmazott.prototype.getTravelLength = function () {
        var result = 0;
        // for (let i = 0; i < this.utazasok.length; i++) {
        //     result += this.utazasok[i].getTavolsag()
        // }
        for (var _i = 0, _a = this.utazasok; _i < _a.length; _i++) {
            var utazas = _a[_i];
            result += utazas.getTavolsag();
        }
        return result;
    };
    return Alkalmazott;
}());
var robi = new Alkalmazott("Róbert");
var peti = new Alkalmazott("Péter");
robi.setNev("Bárdonicsek Róbert");
peti.setNev("lssfffééj");
var utazas1 = new Utazas("Budapest", 550, true);
var utazas2 = new Utazas("Pécs", 60, false);
var utazas3 = new Utazas("Balaton", 300, false);
robi.addUtazas(utazas1);
robi.addUtazas(utazas2);
robi.addUtazas(utazas3);
var alkalmazott = {
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
};
for (var key in alkalmazott.utazasai[1]) {
    console.log(key + " : " + alkalmazott.utazasai[1][key]);
}
//terfogatLista.push(100)
kutya[0] = 100;
//console.log(nev);
nev = "Józsi";
// console.log("terfogatLista:" + terfogatLista);
// console.log("kutya:" + kutya);
console.log(robi.getTravelLength());
var Szemely = /** @class */ (function () {
    function Szemely(nev, szulIdo, nem) {
        this.nev = nev;
        this.szulIdo = szulIdo;
        this.nem = nem;
        this.tajszam = '';
    }
    return Szemely;
}());
var Tanulo = /** @class */ (function (_super) {
    __extends(Tanulo, _super);
    function Tanulo(nev, szulIdo, nem, intezmeny, jogviszony) {
        var _this = _super.call(this, nev, szulIdo, nem) || this;
        _this.intezmeny = intezmeny;
        _this.jogviszony = jogviszony;
        return _this;
    }
    Tanulo.prototype.log = function (msg, date) {
        console.log(msg);
    };
    return Tanulo;
}(Szemely));
var Tanar = /** @class */ (function (_super) {
    __extends(Tanar, _super);
    function Tanar() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    return Tanar;
}(Szemely));
var Munkaido = /** @class */ (function () {
    function Munkaido() {
        this.kezdet = 8;
        this.vege = 17;
    }
    return Munkaido;
}());
var tanulo1 = new Tanulo("Robi", new Date('2000-03-01'), 'f', 'PTE', true);
