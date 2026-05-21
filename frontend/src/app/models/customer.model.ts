export interface Customer {
  id?: number;
  name: string;
  phone: string;
  cpf: string;
  birthDate?: Date;
  address: string;
  neighborhood?: string;
  referencePoint?: string;
}
