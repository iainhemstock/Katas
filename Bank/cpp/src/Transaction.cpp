#include "Transaction.h"

Transaction::Transaction(const std::string& date, const int amount)
{
        this->m_date = date;
        this->m_amount = amount;
}

const std::string
Transaction::date() const
{
        return this->m_date;
}

const int
Transaction::amount() const
{
        return this->m_amount;
}

const bool
Transaction::operator==(const Transaction& rhs) const
{
        return this->m_date == rhs.m_date && this->m_amount == rhs.m_amount;
}
