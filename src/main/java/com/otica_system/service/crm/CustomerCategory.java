package com.otica_system.service.crm;

public enum CustomerCategory {
    Novo("Novo"),
    Recorrente("Recorrente"),
    VIP("VIP"),
    Inativo("Inativo");

    private final String label;

    CustomerCategory(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
