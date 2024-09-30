import { Hotel } from "./hotel";
import { TuristickaAgencija } from "./turisticka-agencija";

export class Aranzman {
    id!: number;
    ukupnaCena!: number;
    datumRealizacije!: Date;
    placeno!: boolean;
    hotel!: Hotel;
    turistickaAgencija!: TuristickaAgencija;
}