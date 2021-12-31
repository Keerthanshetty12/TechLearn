import { Assessment } from "./assessment";
import { User } from "./user";

export class UserAssessment {
    userAssessmentId:number;
    user:User;
    assessment:Assessment;
    score:number;
    badge:String;
}